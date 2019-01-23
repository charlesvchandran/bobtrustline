# bobtrustline


## Bob receives the credit - Alice to use this api to send the credit

API -> /api/pay to record the payment and show in terminal the debt deails

<code>
curl -H "Content-Type: application/json" -X POST http://localhost:8081/bobtrustline/api/payment -d "{\"credit\":10, \"debt\":10}"
</code>

### request body json
----------------

<code>
{
  "credit": 10
}
</code>
