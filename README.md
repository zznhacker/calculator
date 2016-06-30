#Android Caculator

这款**caculator**主要分为两个模式，一个是普通模式，一个是科学模式（只有进制换算的简易版）

代码逻辑如下：

```sequence
NormalCalculator->Main: get textview's text
ProgrammingCalculator->Main:get textview's text
NormalCalculator->GolbalResultStorage:set up or get the global result
ProgrammingCalculator->GolbalResultStorage:set up or get the global result

```
