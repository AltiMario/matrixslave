# matrixslave ver 0.1
It's a slave service (to combine with matrixserver) for processing multiple operations of row * column (of a matrix) 

# Rational
Distribute the computational load of matrix multiplication, across online services.

Matrixslave is 
 - a simple JSON RESTful API service (designed to be a slave)
 - that receive HTTP requests (of calculation)
 - and return JSON results
 - from one or more masters

## Technical Requirements

* Java 7+ / Clojure 1.8 / Leiningen 2.x


## Usage  

* Edit the file config/config.edn to set where the slave have to run

* To run the app

    $ java -jar matrixslave.jar

- open the browser at http://localhost:3000/v1/slave/health-check to check if everything is fine 

- wait for the master calls


* To run the test

    $ lein midje
