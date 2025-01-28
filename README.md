# rabbitmq
To add local setup, overview, and other details of your project, you can update the `README.md` file. Here is a suggested structure for the `README.md` file:

## Project overview

* This project consists of two main components: `rabbitmq-producer` and `rabbitmq-consumer`.
* The `rabbitmq-producer` component is responsible for sending messages to a RabbitMQ queue.
* The `rabbitmq-consumer` component is responsible for receiving and processing messages from the RabbitMQ queue.

## Local setup

### Prerequisites

* Java 17
* Maven
* RabbitMQ server

### Steps

1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd rabbitmq
   ```

2. Start the RabbitMQ server:
   * Ensure RabbitMQ is installed and running on your local machine.
   * Default RabbitMQ credentials are used in the project (`guest`/`guest`).

3. Build and run the `rabbitmq-producer`:
   ```sh
   cd rabbitmq-producer
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

4. Build and run the `rabbitmq-consumer`:
   ```sh
   cd ../rabbitmq-consumer
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

## Usage

* The `rabbitmq-producer` exposes a REST API to create orders and send them to the RabbitMQ queue.
* The `rabbitmq-consumer` listens to the RabbitMQ queue and processes the orders.

### Create an order

* Send a POST request to `http://localhost:8080/api/orders` with the order details in the request body.
* Example request body:
  ```json
  {
    "orderId": "123",
    "item": "Laptop",
    "quantity": 1,
    "price": 1000.00,
    "status": "NEW"
  }
  ```

## Configuration

* The RabbitMQ configuration for the `rabbitmq-producer` can be found in `rabbitmq-producer/src/main/java/com/egov/rabbitmqproducer/config/RabbitMQConfig.java`.
* The RabbitMQ configuration for the `rabbitmq-consumer` can be found in `rabbitmq-consumer/src/main/java/com/egov/rabbitmqconsumer/config/RabbitMQConfig.java`.

## License

* This project is licensed under the Apache License, Version 2.0. See the `rabbitmq-consumer/.mvn/wrapper/maven-wrapper.properties` and `rabbitmq-producer/.mvn/wrapper/maven-wrapper.properties` files for more details.
