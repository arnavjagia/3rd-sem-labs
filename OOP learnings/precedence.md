<html><head>
</head>
<body>



<h2><font color="navy">Java Operator Precedence Table</font></h2>

<table border="1" cellspacing="1" cellpadding="2">
<tbody><tr><th>Precedence</th><th>Operator</th><th>Type</th><th>Associativity</th></tr>
<tr>
  <td align="center">15</td>
  <td align="center">()<br>[]<br>·</td>
  <td>Parentheses<br>Array subscript<br>Member selection<br></td>
  <td align="center">Left to Right<p></p></td>
</tr>
<tr>
  <td align="center">14</td>
  <td align="center">++<br>--</td>
  <td>Unary post-increment<br>Unary post-decrement</td>
  <td align="center">Left to Right</td>
</tr>
 <tr>
  <td align="center">13</td>
  <td align="center">++<br>--<br>+<br>-<br>!<br>~<br>( <i>type</i> )</td>
  <td>Unary pre-increment<br>Unary pre-decrement<br>Unary plus<br>Unary minus<br>Unary logical negation<br>Unary bitwise complement<br>Unary type cast</td>
  <td align="center">Right to left</td>
</tr>
<tr>
  <td align="center">12</td>
  <td align="center"> * <br> / <br> % </td>
  <td>Multiplication<br>Division<br>Modulus</td>
  <td align="center">Left to right</td>
</tr>
<tr>
  <td align="center">11</td>
  <td align="center">+<br>-<o:p></o:p></td>
  <td>Addition<br>Subtraction</td>
  <td align="center">Left to right</td>
</tr>
<tr>
  <td align="center">10</td>
  <td align="center">&lt;&lt;<br>&gt;&gt;<br>&gt;&gt;&gt;</td>
  <td>Bitwise left shift<br>Bitwise right shift with sign extension<br>Bitwise right shift with zero extension</td>
  <td align="center">Left to right</td>
</tr>
<tr>
  <td align="center">9</td>
  <td align="center">&lt;<br>&lt;=<br>&gt;<br>&gt;=<br>instanceof</td>
  <td>Relational less than<br>Relational less than or equal<br>Relational greater than<br>Relational greater than or equal<br>Type comparison (objects only)</td>
  <td align="center">Left to right</td>
</tr>
<tr>
  <td align="center">8</td>
  <td align="center">==<br>!=</td>
  <td>Relational is equal to<br>Relational is not equal to</td>
  <td align="center">Left to right</td>
</tr>
 <tr>
  <td align="center">7</td>
  <td align="center">&amp;</td>
  <td>Bitwise AND</td>
  <td align="center">Left to right</td>
</tr>
 <tr>
  <td align="center">6</td>
  <td align="center">^</td>
  <td>Bitwise exclusive OR</td>
  <td align="center">Left to right</td>
</tr>
<tr>
  <td align="center">5</td>
  <td align="center">|</td>
  <td>Bitwise inclusive OR</td>
  <td align="center">Left to right</td>
</tr>
<tr>
  <td align="center">4</td>
  <td align="center">&amp;&amp;</td>
  <td>Logical AND<p></p>
  </td>
  <td align="center">Left to right</td>
</tr>
 <tr>
  <td align="center">3</td>
  <td align="center">||</td>
  <td>Logical OR</td>
  <td align="center">Left to right</td>
</tr>
<tr>
  <td align="center">2</td>
  <td align="center">? :</td>
  <td>Ternary conditional</td>
  <td align="center">Right to left</td>
</tr>
<tr>
  <td align="center">1</td>
  <td align="center">=<br>+=<br>-=<br>*=<br>/=<br>%=</td>
  <td>Assignment<br>Addition assignment<br>Subtraction assignment<br>Multiplication assignment<br>Division assignment<br>Modulus assignment</td>
  <td align="center">Right to left</td>
</tr>
</tbody></table>

<p><i>Larger number means higher precedence</i>.</p>


</body></html>