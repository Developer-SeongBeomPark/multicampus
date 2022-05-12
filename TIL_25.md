### DAY 25(5/12 Thu)

---

[]()

[]()



##### Finding HTML Elements

![02](TIL_25.assets/02.jpg)

```html
<!DOCTYPE html>
<html>
<body>
 
<p id="intro">Hello World!</p>
 
<p>This example demonstrates the <b>getElementById</b> method!</p>
 
<p id="demo"></p>
 
<script>
var myElement = document.getElementById("intro");
document.getElementById("demo").innerHTML = 
"The text from the intro paragraph is " + myElement.innerHTML;
</script>
 
</body>
</html>
```

