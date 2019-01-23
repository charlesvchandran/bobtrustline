# bobtrustline


## Bob receives the credit 

API -> /api/pay to record the payment and show in terminal the debt deails

curl -H "Content-Type: application/json" -X POST http://localhost:8081/bobtrustline/api/payment -d "{\"credit\":10}"

### request body json
----------------
+
{
  "credit": 10
}
