#Android Caculator

This **caculator** has two function: Normal mode and Programming mode(not completed yet).

-------------------

[TOC]

##Sequence Diagram
The sequence diagram of this project is：

```sequence
NormalCalculator->Main: get textview's text
ProgrammingCalculator->Main:get textview's text
NormalCalculator->GolbalResultStorage:set up or get the global result
ProgrammingCalculator->GolbalResultStorage:set up or get the global result

```

##Class Intro
一共有4个类：
- Main
- NormalCalculator
- Programming Caculator
- MyApplication

The NormalCalculator and ProgrammingCalculator are two Fragment classes. They contains the logic of the buttons in the Fragment.

The main activity is using tabbed activity as its template. Also, the result textview is also design in the main activity.

MyApplication is to store the data of the result for NormalCalculator and ProgrammingCalculator to use.

