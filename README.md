# Quarkus + KeyCloack Demo

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Variables

| Name | Default Value |
| ---- | ------------- |
| KEYCLOAK_URL | https://localhost:8543/realms/quarkus |
| KEYCLOAK_CLIENT | backend-service |
| KEYCLOAK_CLIENT_SECRET | secret |
| MYSQL_URL | jdbc:mariadb://localhost:3306/inventory |
| MYSQL_USER | demo |
| MYSQL_PASS | demo |

## KeyCloak Server

We use the containerized version of keycloak 10.0.2 to run this demo.
You can run one executing:
```
docker run -d --name keycloak -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -p 8543:8443 -v "$(pwd)"/config/keycloak-keystore.jks:/etc/keycloak-keystore.jks quay.io/keycloak/keycloak:17.0.1 start  --hostname-strict=false --https-key-store-file=/etc/keycloak-keystore.jks
```

Once running, access the admin console 'localhost:8180/auth', create a new Realm called 'quarkus' and import the file `quarkus-realm.json`.

## Running the application in dev mode

First, you'll need a MariaDB instance running so execute:
```
docker run -it --rm --name mariadb -p 3306:3306 -e MARIADB_ROOT_PASSWORD=demo -e MARIADB_USER=demo -e MARIADB_PASSWORD=demo -e MARIADB_DATABASE=inventory -d quay.io/rlam/mariadb:10.5-debezium
```

Then, you can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Test the application

Go to 'localhost:8080/dashboard' using a Token corresponding to `userx` in Keycloak

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