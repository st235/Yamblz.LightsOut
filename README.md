# Yamblz.LightsOut

## Engine usage
### Setup
- First of all, you need to init the engine object. GameEngineProvider class 
permit you to engine core, for performance, use:
```java
Engine engine = GameEngineProvider.getEngine();
```
**Note:** _Engine is singleton object, that means, all next calls of **getEngine** will
return the same engine object._

- The next one step is to init **Field** class, by:
```java
Field field = engine.obtainNewField(Size size);
```
Available **Size** classes:
1. SquareSize (represent the square area, constructor takes one parameter)

**Initialization finished**

**Note:** unfinished initialization will crash your program with
_SessionNotObtainedException_.

### Available methods

The **Engine** interface
```java
    Field obtainNewField(Size size);

    Field getOriginField();
    Field getPreviousField(int steps);

    Field clickCurrentField(Point point);
    int calculateCurrentScore();
```

- **getOriginField** resets current matrix
- **getPreviousField** moves your game board to counted steps back. To make single back movement call _getPreviousField(1)_
- **clickCurrentField** obtain new field, by user click. Use with **Click** class.
- **calculateCurrentScore** returns current score

### Point

Point interface
```java
    int getX();
    int getY();
```

There are a lot of point inherited classes. The most valuable is 
 **Click** class. 
 
 ```java
public Click(int x, int y)
 ```