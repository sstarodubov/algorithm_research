import pika


params = pika.ConnectionParameters("localhost")
conn = pika.BlockingConnection(params)

chanel = conn.channel()


chanel.queue_declare("helloworldq")
