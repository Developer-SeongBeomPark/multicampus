### DAY 18(4/28 Thu)

---

[Tag](#tag)

[Styling](#styling)

[Attribute](#attribute)



#### HTML

---

##### Tag

1. p : paragraph
2. header
   - h1
   - h2
   - h3
   - h4
   - h5
   - h6
3. line
   - hr : 가로 일자 라인
   - br : 한줄 띄어쓰기
4. a : 하이퍼링크 용도







##### Styling

1. Inline Styling

   ```html
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
     body {background-color:lightgrey}
     h1   {color:blue}
     p    {color:green}
   </style>
   </head>
    
   <body>
   <h1>This is a heading</h1>
   <p>This is a paragraph.</p>
   </body>
    
   </html>
   ```

   

2. External Styling(CSS)

   ```html
   <!DOCTYPE html>
   <html>
   <head>
   <link rel="stylesheet" href="styles.css">
   </head>
    
   <body>
   <h1>This is a heading</h1>
   <p>This is a paragraph.</p>
   </body>
    
   </html>
   ```



#####  Attribute



```html
<!DOCTYPE html>
<html>
 
<head>
<style>
p#p01 { <!-- '#' : id를 의미, '.' : class를 의미, '>' : tag를 의미 -->
    color: blue;
}
</style>
</head>
<body>
 
<p>This is a paragraph.</p>
<p>This is a paragraph.</p>
<p>This is a paragraph.</p>
<p id="p01">I am different.</p>
 
</body>
</html>
```

```html
<!DOCTYPE html>
<html>
 
<head>
<style>
p.error {<!-- '#' : id를 의미, '.' : class를 의미, '>' : tag를 의미 -->
    color:red;
}
</style>
</head>
<body>
 
<p>This is a paragraph.</p>
<p>This is a paragraph.</p>
<p class="error">I am different.</p>
<p>This is a paragraph.</p>
<p class="error">I am different too.</p>
 
</body>
</html>
```

```html
<!DOCTYPE html>
<html>
<head>
<style>
a:link {<!-- "link" : 링크 방문 전 상태   -->
    color:#000000;
    background-color:transparent;
    text-decoration:none;
}
a:visited {<!-- "visited" : 링크 방문 후 상태   -->
    color:#000000;
    background-color:transparent;
    text-decoration:none;
}
a:hover {<!-- "hover" : 하이퍼링크에 마우스 커서를 올렸을때   -->
    color:#ff0000;
    background-color:transparent;
    text-decoration:underline;
}
a:active {<!-- "link" : 링크 텍스트를 클릭한 순간의 상태   -->
    color:#ff0000;
    background-color:transparent;
    text-decoration:underline;
}
</style>
</head>
 
<body>
 
<p>You can change the default colors of links</p>
 
<a href="ex01.html" target="_blank">HTML Images</a> 
 
</body>
</html>
```

```html
<!DOCTYPE html>
<html>
<body>
 
<h2>Spectacular Mountains</h2>
<img src="pic_mountain.jpg" alt="Mountain View" style="width:304px;height:228px">
 
</body>
</html>
```

