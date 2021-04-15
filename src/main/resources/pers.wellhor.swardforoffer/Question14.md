# 割绳子DP（动态规划算法）

1. 数据前提 均值不等式

```
   Hn ≤ Gn ≤ An ≤ Qn
   即：
    调和平均数不超过几何平均数
    几何平均数不超过算术平均数
    算术平均数不超过平方平均数
```

调和平均数:
<img alt="" style="vertical-align:-3.255ex;width:29.801ex;height:7.384ex;" src="https://bkimg.cdn.bcebos.com/formula/466622a2ddd3f2a6c72efea2b67acf54.svg">

如何理解调和平均数: https://www.zhihu.com/question/23096098

几何平均数:
<img alt="" style="vertical-align:-3.255ex;width:29.801ex;height:7.384ex;" src="https://bkimg.cdn.bcebos.com/formula/f87a239f4c276e670658b8feb95cec73.svg">

算术平均数:
<img alt="" style="vertical-align:-1.755ex;width:35.263ex;height:9.509ex;" src="https://bkimg.cdn.bcebos.com/formula/cda6e439a004dbbe2a21a050f3809d32.svg">

平方平均数:
<img alt="" style="vertical-align:-2.63ex;width:40.39ex;height:11.009ex;" src="https://bkimg.cdn.bcebos.com/formula/d2b077afed24ad7bb205da574fa56716.svg">