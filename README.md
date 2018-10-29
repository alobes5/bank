# bank
bank account
```
./mvnw clean install
./mvnw clean package
./mvnw test
./mvnw compile
./mvnw spring-boot:run
```

Enpoints

```
{
	"info": {
		"_postman_id": "2cbe9b2a-6503-4024-9636-9f6af0f44f39",
		"name": "bank",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Accounts",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/accounts",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"accounts"
					]
				}
			},
			"response": []
		},
		{
			"name": "Accounts id",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "pwd",
							"type": "string"
						},
						{
							"key": "username",
							"value": "admin",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/accounts/123",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"accounts",
						"123"
					]
				}
			},
			"response": []
		},
		{
			"name": "Bank",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "pwd",
							"type": "string"
						},
						{
							"key": "username",
							"value": "admin",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/bank/123",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"bank",
						"123"
					]
				}
			},
			"response": []
		},
		{
			"name": "Accounts create",
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "username",
							"value": "admin",
							"type": "string"
						},
						{
							"key": "password",
							"value": "pwd",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/accounts/123",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"accounts",
						"123"
					]
				}
			},
			"response": []
		}
	]
}
```
