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
 
 ## License
 
 MIT License
 
 Copyright (c) 2017 Alexander Dadukin, Irina Kravtsova, Alena Malchikhina, Denis Verentsov
 
 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
 
 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
