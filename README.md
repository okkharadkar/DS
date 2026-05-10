# Commands to Run All Practicals

---

# Assignment 1 — Socket Programming

## Compile

```bash id="g6kz0n"
javac Server.java
javac Client.java
```

---

## Run Server

```bash id="5o6t0w"
java Server
```

---

## Run Client (in another terminal)

```bash id="7q7e9s"
java Client
```

---

# Assignment 2 — Java RMI

## Compile All Files

```bash id="wmjlwm"
javac *.java
```

---

## Start RMI Registry

```bash id="rfjlwm"
rmiregistry
```

Keep this terminal open.

---

## Run Server

```bash id="5jlwmn"
java AddServer
```

---

## Run Client (another terminal)

```bash id="vjlwm0"
java AddClient
```

---

# Assignment 3 — CORBA (Calculator/String Operations)

## Compile IDL File

```bash id="4jlwm1"
idlj -fall Calculator.idl
```

---

## Compile Java Files

```bash id="6jlwm2"
javac *.java
```

---

## Start ORB Naming Service

```bash id="7jlwm3"
tnameserv -ORBInitialPort 1050
```

---

## Run Server

```bash id="8jlwm4"
java CalculatorServer -ORBInitialPort 1050 -ORBInitialHost localhost
```

---

## Run Client

```bash id="9jlwm5"
java CalculatorClient -ORBInitialPort 1050 -ORBInitialHost localhost
```

---

# Assignment 4 — MPI Sum Program

## Compile

```bash id="0jlwm6"
javac -cp mpj.jar MPI_Sum.java
```

---

## Run

```bash id="1jlwm7"
mpjrun.bat -np 4 MPI_Sum
```

---

## Alternative Full Path

```bash id="2jlwm8"
C:\mpj\mpj-v0_44\bin\mpjrun.bat -np 4 MPI_Sum
```

---

# Assignment 5 — Berkeley Algorithm

## Compile

```bash id="3jlwm9"
javac Berkeley.java
```

---

## Run

```bash id="4jlwm0"
java Berkeley
```

---

# Assignment 6 — Token Ring Mutual Exclusion

## Compile

```bash id="5jlwm1"
javac TokenRing.java
```

---

## Run

```bash id="6jlwm2"
java TokenRing
```

---

# Assignment 7 — Election Algorithms

---

# Bully Algorithm

## Compile

```bash id="7jlwm3"
javac Bully.java
```

---

## Run

```bash id="8jlwm4"
java Bully
```

---

# Ring Algorithm

## Compile

```bash id="9jlwm5"
javac Ring.java
```

---

## Run

```bash id="0jlwm7"
java Ring
```

---

# Useful Notes for README

---

# Check Java Version

```bash id="1jlwm8"
java -version
```

---

# Check Javac Version

```bash id="2jlwm9"
javac -version
```

---

# If `mpjrun.bat` Not Recognized

Use full path:

```bash id="3jlwm0"
C:\mpj\mpj-v0_44\bin\mpjrun.bat
```

Or add MPJ bin folder to PATH variable.

---

# Recommended Execution Order

| Practical           | Run Order                     |
| ------------------- | ----------------------------- |
| Socket Programming  | Server → Client               |
| RMI                 | rmiregistry → Server → Client |
| CORBA               | tnameserv → Server → Client   |
| MPI                 | Directly run mpjrun           |
| Berkeley            | Direct run                    |
| Token Ring          | Direct run                    |
| Election Algorithms | Direct run                    |