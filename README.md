# Nybble-AutomationWeb

## Reporting
### Comands
- allure serve .\build\allure-results\

## Browser options
### Run headless Chrome
- ChromeOptions options = new ChromeOptions();
  options.addArguments("--headless");
### Maximize Window
- driver.manage().window().maximize();