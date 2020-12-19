# HTML Logger

**Version 0.1.0**

An extremely simple HTML output Java logger.

---

## How Its Used

#### When called the logger will build the environment:
```
{protoject-root} / htmlLogs / index.html

//index.html will contain your logs at the end of execution.
```

#### Recommended Usage
```Java

private static HTMLLoggerImpl LOGGER = HTMLLoggerImpl.getLogger();

LOGGER.log(String customPriority, String errorMessage)
LOGGER.okay(String errorMessage);
LOGGER.error(String errorMessage);
LOGGER.rip(String errorMessage);
```

#### Example Output
```HTML
<!DOCTYPE html><html style="background:#2e2e2e; margin:0;font-family: arial;font-size: 9pt;"><body>

<p style="color:cornflowerblue" > LOG : TEST_CUSTOM_PRIORITY : 2020-12-18 at 19:03:24 CST
 <br> MSG : Test logger message.</p>
<p style="color:green" > LOG : OKAY : 2020-12-18 at 19:03:24 CST
 <br> MSG : Test 'okay' logger message.</p>
<p style="color:orange" > LOG : ERROR : 2020-12-18 at 19:03:24 CST
 <br> MSG : Test 'error' logger message.</p>
<p style="color:red" > LOG : RIP : 2020-12-18 at 19:03:24 CST
 <br> MSG : Test 'rip' logger message.</p>
```

---

## Versions Used
* OpenJDK 11.0.2
* Gradle-5.6.4
