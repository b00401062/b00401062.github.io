## Homework 2
B00401062 羅文斌

- 2.46
    1. This is not a good design choice because $500*1+300*10+100*3=3800≤(500*0.75*1+300*10+100*3)*1.1=4042.5$
    2. $3800÷(500*1*0.5+300*10+100*3)=107.04\%$ <br> $3800÷(500*1*0.1+300*10+100*3)=113.43\%$
- 2.47
    1. $0.7 * 2 + 0.1 * 6 + 0.2 * 3 = 2.6$
    2. $\frac{1}{0.7 * x + 0.1 * 6 + 0.2 * 3}=\frac{1}{2.6}*1.25 \implies x=1.26$
    3. $\frac{1}{0.7 * x + 0.1 * 6 + 0.2 * 3}=\frac{1}{2.6}*1.50 \implies x=0.76$
- 3.12
$62_8*12_8=110010_2*1010_2$

||Step|Multiplier|Multiplicand|Product|
|---------|----|:--------:|:----------:|:-----:|
|0|Initial value|00101<b>0</b>|000000110010|000000000000|
|1|1: 0 &rArr; No operation|00101<b>0</b>|000000110010|000000000000|
|1|2: Shift left Multiplicand|00101<b>0</b>|000001100100|000000000000|
|1|3: Shift right Multiplier|00010<b>1</b>|000001100100|000000000000|
|2|1a: 1 &rArr; Prod = Prod + Mcand|00010<b>1</b>|000001100100|000001100100|
|2|2: Shift left Multiplicand|00010<b>1</b>|000011001000|000001100100|
|2|3: Shift right Multiplier|00001<b>0</b>|000011001000|000001100100|
|3|1: 0 &rArr; No operation|00001<b>0</b>|000011001000|000001100100|
|3|2: Shift left Multiplicand|00001<b>0</b>|000110010000|000001100100|
|3|3: Shift right Multiplier|00000<b>1</b>|000110010000|000001100100|
|4|1a: 1 &rArr; Prod = Prod + Mcand|00000<b>1</b>|000110010000|000111110100|
|4|2: Shift left Multiplicand|00000<b>1</b>|001100100000|000111110100|
|4|3: Shift right Multiplier|00000<b>0</b>|001100100000|000111110100|
|5|1: 0 &rArr; No operation|00000<b>0</b>|001100100000|000111110100|
|5|2: Shift left Multiplicand|00000<b>0</b>|011001000000|000111110100|
|5|3: Shift right Multiplier|00000<b>0</b>|011001000000|000111110100|
|6|1: 0 &rArr; No operation|00000<b>0</b>|011001000000|000111110100|
|6|2: Shift left Multiplicand|00000<b>0</b>|110010000000|000111110100|
|6|3: Shift right Multiplier|00000<b>0</b>|110010000000|000111110100|

- 3.14
    - Hardware: There are 3 cycles in each iteration: add (step 1a), shift (step 2 & 3), check stopping criterion. Therefore, total time units $= 3*8*4=96$.
    - Software: There are 5 cycles in each iteration: decide to add or not (step 1), add (step 1a), shift left multiplicand (step 2), shift right multiplier (step 3), check stopping criterion. Therefore, total time units $= 5*8*4=160$.
- 3.18
$74_8÷21_8=111100_2÷10001_2$

||Step|Quotient|Divisor|Remainder|
|---------|----|:--------:|:----------:|:-----:|
|0|Initial value|000000|010001000000|000000111100|
|1|1: Rem = Rem – Div|000000|010001000000|101111111100|
|1|2b: Rem < 0 ⇒ +Div, sll Q, Q0 = 0|000000|010001000000|000000111100|
|1|3: Shift Div right|000000|001000100000|000000111100|
|2|1: Rem = Rem – Div|000000|001000100000|111000011100|
|2|2b: Rem < 0 ⇒ +Div, sll Q, Q0 = 0|000000|001000100000|000000111100|
|2|3: Shift Div right|000000|000100010000|000000111100|
|3|1: Rem = Rem – Div|000000|000100010000|111100101100|
|3|2b: Rem < 0 ⇒ +Div, sll Q, Q0 = 0|000000|000100010000|000000111100|
|3|3: Shift Div right|000000|000010001000|000000111100|
|4|1: Rem = Rem – Div|000000|000010001000|111110110100|
|4|2b: Rem < 0 ⇒ +Div, sll Q, Q0 = 0|000000|000010001000|000000111100|
|4|3: Shift Div right|000000|000001000100|000000111100|
|5|1: Rem = Rem – Div|000000|000001000100|111111111000|
|5|2b: Rem < 0 ⇒ +Div, sll Q, Q0 = 0|000000|000001000100|000000111100|
|5|3: Shift Div right|000000|000000100010|000000111100|
|6|1: Rem = Rem – Div|000000|000000100010|000000011010|
|6|2a: Rem ≥ 0 ⇒ sll Q, Q0 = 1|000001|000000100010|000000011010|
|6|3: Shift Div right|000001|000000010001|000000011010|
|7|1: Rem = Rem – Div|000001|000000010001|000000001001|
|7|2a: Rem ≥ 0 ⇒ sll Q, Q0 = 1|000011|000000010001|000000001001|
|7|3: Shift Div right|000011|000000001000|000000001001|

- 3.27
Half precision is represented as $x = (−1)^\text{sign} × (1 + \text{fraction}) × 2^\text{exponent−bias}$. In the case of $-1.5625\times10^{-1}$, $-1.5625_{10}×10^{-1}=-0.15625_{10}×10^0=-0.00101_2×2^0=-1.01_2×2^{-3}$. Therefore, the sign bit is $1$, the fraction bits are $0100000000$, and the exponent bits are $(-3+15)_{10}=12_{10}=01100_2$. Therefore, the half precision representation of  $-1.5625\times10^{-1}$ is $1011000100000000$.
