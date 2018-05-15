Items sent to rabbit adapter and wrapped into AuctionItems which then sent to JMS adapter.

- Hit enter multiple times to send item. Type "exit" to quit.
- Price begins with $10.00 and increases each time item is sent by $5.00.
- The first 3 items will be sent though "Moderate priced outbound channel".
- The subsequent items, from price $25.00, will be sent though "High priced outbound channel".