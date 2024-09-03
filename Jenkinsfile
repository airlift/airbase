AGENT_YAML = '''
    apiVersion: v1
    kind: Pod
    spec:
      containers:
      - name: maven
        image: maven:3.8.6-openjdk-8-slim
        tty: true
        resources:
          requests:
            memory: "1Gi"
            cpu: "500m"
          limits:
            memory: "1Gi"
            cpu: "500m"
        command:
        - cat
'''

pipeline {

    agent {
        kubernetes {
            defaultContainer 'maven'
            yaml AGENT_YAML
        }
    }

    environment {
        GPG_SECRET     = credentials('presto-release-gpg-secret')
        GPG_TRUST      = credentials("presto-release-gpg-trust")
        GPG_PASSPHRASE = credentials("presto-release-gpg-passphrase")

        GITHUB_OSS_TOKEN_ID = 'github-personal-token-wanglinsong'

        SONATYPE_NEXUS_CREDS    = credentials('presto-sonatype-nexus-creds')
        SONATYPE_NEXUS_PASSWORD = "$SONATYPE_NEXUS_CREDS_PSW"
        SONATYPE_NEXUS_USERNAME = "$SONATYPE_NEXUS_CREDS_USR"
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '100'))
        disableConcurrentBuilds()
        disableResume()
        overrideIndexTriggers(false)
        timeout(time: 30, unit: 'MINUTES')
        timestamps()
    }

    parameters {
        booleanParam(name: 'PERFORM_MAVEN_RELEASE',
                     defaultValue: false,
                     description: 'Release and update development version when running in the master')
    }

    stages {
        stage('Setup') {
            steps {
                sh 'apt update && apt install -y bash build-essential git gpg python3 python3-venv'
            }
        }

        stage ('Prepare to Release') {
            steps {
                script {
                    env.REPO_CURRENT_VERSION = sh(
                        script: 'mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -Dexpression=project.version -q -ntp -DforceStdout',
                        returnStdout: true).trim()
                }
                echo "current version: ${REPO_CURRENT_VERSION}"

                sh '''
                    git config --global --add safe.directory ${PWD}
                    git config --global user.email "oss-release-bot@prestodb.io"
                    git config --global user.name "oss-release-bot"
                '''

                sh '''
                    mvn release:prepare -B -DskipTests \
                        -DautoVersionSubmodules=true \
                        -DgenerateBackupPoms=false

                    git branch
                    git log --pretty="format:%ce: %s" -8
                    SCM_TAG=$(cat release.properties | grep scm.tag=)
                    echo ${SCM_TAG#*=} > repo-release-tag.txt
                '''

                script {
                    env.REPO_RELEASE_TAG = sh(
                        script: 'cat repo-release-tag.txt',
                        returnStdout: true).trim()
                }
                echo "release tag: ${REPO_RELEASE_TAG}"
            }
        }

        stage ('Release Maven Artifacts') {
            when {
                allOf {
                    expression { params.PERFORM_MAVEN_RELEASE }
                    branch 'master'
                }
            }

            steps {
                echo "Update GitHub Repo"
                withCredentials([usernamePassword(
                        credentialsId: "${GITHUB_OSS_TOKEN_ID}",
                        passwordVariable: 'GIT_PASSWORD',
                        usernameVariable: 'GIT_USERNAME')]) {
                    sh '''
                        git switch -c master
                        git branch

                        git --no-pager log --since="60 days ago" --graph --pretty=format:'%C(auto)%h%d%Creset %C(cyan)(%cd)%Creset %C(green)%cn <%ce>%Creset %s'
                        head -n 18 pom.xml
                        ORIGIN="https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/prestodb/airbase.git"
                        git push --follow-tags --set-upstream ${ORIGIN} master
                    '''
                }

                echo "Release ${REPO_RELEASE_TAG} maven artifacts"
                sh '''#!/bin/bash -ex
                    export GPG_TTY=$TTY
                    gpg --batch --import ${GPG_SECRET}
                    echo ${GPG_TRUST} | gpg --import-ownertrust -
                    gpg --list-secret-keys
                    echo "allow-loopback-pinentry" >> ~/.gnupg/gpg-agent.conf
                    printenv | sort

                    git checkout ${REPO_RELEASE_TAG}
                    git status
                    git branch
                    git log -8
                    head -n 18 pom.xml

                    mvn -s settings.xml -V -B -U -e -T2C deploy \
                        -DautoReleaseAfterClose=true \
                        -Dgpg.passphrase=${GPG_PASSPHRASE} \
                        -DkeepStagingRepositoryOnCloseRuleFailure=true \
                        -DkeepStagingRepositoryOnFailure=true \
                        -DskipTests \
                        -Poss-release \
                        -Pdeploy-to-ossrh \
                        -DstagingProgressTimeoutMinutes=10
                '''
            }
        }
    }
}
