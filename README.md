# Jenkins Learning Calculator API

A Java 21 Spring Boot calculator API. It is built by Jenkins and can run as a container on OpenShift.

## Run locally

```sh
mvn spring-boot:run
curl "http://localhost:8080/api/calculator/add?a=2&b=3"
curl http://localhost:8080/actuator/health
```

## Build a container

```sh
podman build -t jenkins-learning:latest .
# Docker can be used instead of Podman.
```

## Deploy to OpenShift

1. Build and push the image to a registry your OpenShift cluster can pull from, or build it in OpenShift.
2. Process and apply the deployment template. Replace the image with your image reference.

```sh
oc process -f openshift/app.yaml \
  -p IMAGE=quay.io/YOUR_ACCOUNT/jenkins-learning:latest | oc apply -f -
oc get route jenkins-learning
```

The route exposes the API. The health endpoints used by OpenShift are:

- `/actuator/health/liveness`
- `/actuator/health/readiness`

## Jenkins

The existing Jenkinsfile continues to compile, test, package, and archive the executable JAR. To publish or deploy a container from Jenkins, configure registry and OpenShift credentials on Jenkins, then add image build/push and `oc apply` steps that use those credentials.
