## Homework 2

### Execution

- Format:
```bash==
make
./agent [IP] [port] [loss rate]
./receiver [IP] [port] [file]
./sender [IP] [port] [agent IP] [agent port] [receiver IP] [receiver port] [file]
```
- Example:
```bash==
make
./agent 127.0.0.1 8081 0.01
./receiver 127.0.0.1 8082 result.pdf
./sender 127.0.0.1 8080 127.0.0.1 8081 127.0.0.1 8082 report.pdf
```
- Notice: To prevent the standard outputs of agent, receiver and sender from interleaving, you have to run the three programs in separate terminals or direct the standard outputs to separate files.

### Program structure

- The format of TCP datagram: __Source address__: 16 bytes. __Destination address__: 16 bytes. __Sequence number__: 4 bytes. __Acknowledge number__: 4 bytes. __ACK bit__: 1 byte. __FIN bit__: 1 byte. __Data__: maximum of 1000 bytes.
- Flow charts are represented with step-by-step pseudocodes as shown in the next two pages.

### Difficulties and solutions

- __Design of TCP datagram__. The TCP datagram needed for the assignment is not exactly the format on the textbook. Specifically, the source and destination addresses have to include IP addresses inside so that they could be passed to C functions, like `recvfrom` and `sendto`. In order to send _ACK_, _FIN_ and _FINACK_, I adopted the same desgin as in the real-world TCP datagram where the combinations of __ACK bit__ and __FIN bit__ meet the need. Referring to the slides and the textbook helps put together the puzzle of TCP.
- __The logic of Go Back N and congestion control__. The sender and the receiver have to coordinate and implement the same logic to make congestion control works. This is essentially the most difficult part in the assignment. Given on the slides and the textbook are the finite state machine diagrams. But FSM diagrams are far from real implementation. Details have to be taken care of with great caution. For example, actions can overlap in different transitions, and a state would depend on multiple variables. All these factors make the effect of congestion control unpredictable. The only solution is trial and error.

### Agent:

1. Initialize socket address and create UDP socket.
2. Receive packets from sender and receiver.
3. Check packet type:
- __If__ packet type = _Data_ (`!ACK && !FIN`):
    1. Determine to drop/keep a packet:
    - __If__ to drop the packet: __Return to__ Step 2.
    - __Else if__ to keep the packet: Foward packets to destination.
- __Else if__ packet type = _FINACK_ (`ACK && FIN`): Foward packets to destination.
- __Else if__ packet type = _ACK_: Foward packets to destination.
- __Else if__ packet type = _FIN_: Foward packets to destination.
4. __Return to__ Step 2.

### Receiver:
1. Initialize socket address and create UDP socket.
2. __Set__ receive base := 0.
3. Receive packets from sender.
4. __If__ packet type = _FIN_: __Go to__ Step 8.
5. __If__ sequence number = receive base:
    1. Check if the buffer is full or not:
    - __If__ buffer is full: Flush the buffer.
    - __Otherwise__:
        1. Copy packet data to the buffer.
        2. __Set__ receive base := receive base + 1.
6. Send _ACK_ #(receive base - 1) to sender.
7. __Return to__ Step 3.
8. Flush anything left in the buffer.
9. Send _FINACK_ to sender.

### Sender:

1. Initialize socket address and create UDP socket.
2. Set UCP time out interval.
3. Initialize:
- __Set__ send base := 0
- __Set__ threshold := 16
- __Set__ window size := 1
- __Set__ timeout := __false__
4. __Set__ send limit := send base + window size.
5. Check timeout:
- __If__ timeout = __true__: Send all packets from last-sent to send limit.
- __Otherwise__: Resend all packets from send base to send limit.
6. Wait for packets from receiver until timeout:
- __If__ timeout:
    1. __Set__ threshold := max(window size/2, 1)
    2. __Set__ window size := 1
    3. __Return to__ Step 4.
- __Otherwise__:
    1. __If__ acknowledge number = max sequence number: __Go to__ Step 8.
    2. __If__ acknowledge number = send base:
        1. Check if window size < threshold:
        - __If__ window size < threshold: Set window size := window size × 2.
        - __Otherwise__: Set window size := window size + 1.
        2. __Set__ send base := send base + 1.
7. __Return to__ Step 4.
8. Send _FIN_ to receiver.
9. Receive _FINACK_ from receiver.
