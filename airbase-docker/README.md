# Airlift Docker Builder

For modules that contain a file named `.build-airlift-docker`,
the Maven properties below are used to generate a docker image during the
package phase and to deploy/push that image during the delpoy phase.  This 
[docker file](../airbase-docker/src/main/resources/AirliftDockerfile) is
used to build the image.

Note: modules must also contain `.build-airlift` so that the Airlift
launcher tarball is generated. The Maven build will fail if this file
is missing.

## Maven Properties

| Name | Default Value | Details |
| ----- | ------------- | ------- |
| air.docker.skip | false | skip all docker executions |
| air.docker.skip-build | false | skip docker build |
| air.docker.skip-deploy | false | skip docker deploy |
| air.docker.skip-tag | false | skip docker tagging |
| air.docker.verbose | false | enable verbose mode for dockerfile-maven-plugin |
| air.docker.repository | ${project.groupId}/${project.artifactId} | Docker repo image name |
| air.docker.directory | airlift | `AIRLIFT_DIRECTORY` in [AirliftDockerfile](../airbase-docker/src/main/resources/AirliftDockerfile) |
| air.docker.jdk | openjdk:${project.build.targetJdk}-jdk-buster | `JAVA_VERSION` in [AirliftDockerfile](../airbase-docker/src/main/resources/AirliftDockerfile) |
| air.docker.maintainer | ${project.groupId} | `MAINTAINER` in [AirliftDockerfile](../airbase-docker/src/main/resources/AirliftDockerfile) |
| air.docker.user | airlift | `USER` in [AirliftDockerfile](../airbase-docker/src/main/resources/AirliftDockerfile) |
| air.docker.port | 8080 | `APPLICATION_PORT` in [AirliftDockerfile](../airbase-docker/src/main/resources/AirliftDockerfile) |
| air.docker.tag | latest | Docker tag |
