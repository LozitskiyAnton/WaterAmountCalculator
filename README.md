# Water Amount Calculator

Water amount problem implementation Task: There is a landscape with hills and pits which have similar square shape. Each position in this landscape has a specified height. Max number of positions is 32000. Height is between 0 and 32000. For example: the first position has height 5, the second position has height 2. The landscape can be presented as a collection of heights. {5,2,3,4,5,4,0,3,1}

When rain happens, landscape is filled with water. Water is collected inside pits only between hills. For example: collected 9 squares of water.

• implement an application which calculates amount of collected water for any landscapes. Water calculator should implement method long calculateWaterAmount(int[] landscape) • validate correctness of landscape • cover this application with tests (TDD) • use maven to build the application

Stack - Java 17 + Spring + Maven + JUnit5
### To build jar

mvn clean package

### To run application

java -jar [pathToJar]/waterAmountCalculator-0.0.1.jar [initial data]

initial data example - 5,2,3,4,5,4,0,3,1 
