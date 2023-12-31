# My Project

This is a brief description of my project.

## Installation

1. Clone the repository.
2. Run `npm install` to install dependencies.

## Usage

- Run the application with `npm start`.

## Using Postman

You can use Postman to interact with the project's API. Here's how to get started:

1. [Download Postman](https://www.postman.com/downloads/).

2. Import the project's API collection by [clicking here](https://github.com/taregjava/product-crud-json.git). This collection includes pre-defined requests for your project.

3. Open Postman and select the imported collection.

4. You can now use Postman to send requests to the project's API endpoints.

## API Endpoints

### Retrieve All Products (GET)

- *Request:*
    - Method: GET
    - URL: `localhost:8082/api/v1/product`

- *Response:*
  ```json
  {
      "status": 200,
      "message": "Product list retrieved successfully",
      "data": [
          {
              "name": "huau2",
              "price": 5000.0,
              "description": "good choosing"
          },
          {
              "name": "prod2",
              "price": 444.0,
              "description": "good choosing2"
          },
          {
              "name": "s11",
              "price": 7000.0,
              "description": "good one of choosing"
          },
          {
              "name": "s14",
              "price": 9000.0,
              "description": "good one of selecting"
          }
      ]
  }
  ### Retrieve a Product by ID (GET)

- *Request:*
    - Method: GET
    - URL: `localhost:8082/api/v1/product/2`

- *Response:*
  ```json
  {
      "status": 200,
      "message": "Product retrieved successfully",
      "data": {
          "name": "prod2",
          "price": 444.0,
          "description": "good choosing2"
      }
  }

### Create a New Product (POST)

- *Request:*
  - Method: POST
  - URL: `localhost:8082/api/v1/product`
  - Body:
    json
    {
    "name": "s14",
    "price": 9000,
    "description": "good one of selecting"
    }


- *Response:*
  ```json
  {
      "status": 201,
      "message": "Product created successfully",
      "data": {
          "id": 4,
          "name": "s14",
          "description": "good one of selecting",
          "price": 9000.0
      }
  }