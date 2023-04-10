
# Codec Server

While it could be argued that this project is to serve as exercise for me and an example of what I can do for you, the proper function of this app is to transform incoming text using a variety of methods. The app is currently in development.

## Features

- Transform text using a variety of codices
- Save and load codices
- Save and load text
- Run multiple codices on the same text sequentially


## Roadmap

- Complete implementation of caesar cipher
- Complete Dockerization
- Add more codices
  - Complete implementation of atbash cipher
  - Complete implementation of vigenere cipher
  - Complete implementation of rot13 cipher
  - Complete implementation of rot47 cipher
- Add ability to run multiple codices on the same text sequentially
- Add ability to save and load codices
- 


## Running Tests

To run tests, run the following command

```bash
  mvn clean verify
```


## Run Locally

Clone the project

```bash
  git clone git@github.com:odinkirk/codec-server.git
```

### Note: This project requires Java 11 and build using Maven.

Build the project

```bash
  mvn clean package
```

Start the server

```bash
    java -jar target/codec-server-0.0.1-SNAPSHOT.jar
```

