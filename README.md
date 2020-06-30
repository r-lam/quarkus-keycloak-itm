# Quarkus + KeyCloack Demo

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## KeyCloak Server

We use the containerized version of keycloak 10.0.2 to run this demo. 
You can run one executing:
```
docker run --name keycloak -p 8180:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -d quay.io/keycloak/keycloak:10.0.2
```

Once running, access the admin console 'localhost:8180/auth', create a new Realm called 'quarkus' and import the file `quarkus-realm.json`.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Test the application

Go to 'localhost:8080' in your browser and click on the button below the image, it should ask for your credentials.
In this demo, we use the user `userx` and `3421` as password.

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `quarkus-keycloak-itm-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-keycloak-itm-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/quarkus-keycloak-itm-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.