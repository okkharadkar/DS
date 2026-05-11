# Assignment 3: CORBA Calculator Application

## Overview
This assignment implements a distributed calculator application using CORBA (Common Object Request Broker Architecture). It demonstrates inter-process communication between a client and server using the ORB (Object Request Broker) middleware.

## Project Structure
- **CalculatorApp/**: Generated CORBA stubs and skeletons
- **Server.java**: Server implementation that registers the calculator service
- **Client.java**: Client that invokes remote calculator operations

## Prerequisites
- Java Development Kit (JDK 1.8+)
- Set JAVA_HOME to your JDK installation directory

## Compilation

Compile all Java files including CORBA-generated classes:

```bash
javac *.java CalculatorApp/*.java
```

**Note:** You may see warnings about unchecked operations. This is normal for CORBA-generated code.

## Running the Application

### Step 1: Start the Object Request Broker Daemon (orbd)

Open a terminal and run:

```bash
orbd -ORBInitialPort 8080
```

This starts the CORBA naming service on port 8080. Keep this terminal open.

### Step 2: Start the Server

Open another terminal in the Assignment3 directory and run:

```bash
java Server -ORBInitialPort 8080
```

Expected output:
```
Server ready and waiting...
```

The server is now listening for client requests.

### Step 3: Run the Client

Open a third terminal in the Assignment3 directory and run:

```bash
java Client -ORBInitialPort 8080
```

The client will connect to the server and execute calculator operations.

## Key Concepts
- **CORBA**: Middleware enabling communication between distributed objects
- **ORB (Object Request Broker)**: Manages communication between client and server
- **Stubs & Skeletons**: Auto-generated code for marshalling/unmarshalling objects
- **Naming Service**: Allows clients to locate remote objects by name

## Troubleshooting

- **Port Already in Use**: If port 8080 is occupied, change `-ORBInitialPort` to another available port (e.g., 8081)
- **Connection Refused**: Ensure orbd is running before starting the server and client
- **Compilation Errors**: Verify all `.idl` files have been processed and CalculatorApp/ directory exists
