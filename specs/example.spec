# Specification Heading

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
To execute this specification, run
	gauge run specs

## Varolan Senaryolars
tags: single
* Open "chrome" browser with notifications disabled
* Navigate to "https://www.trendyol.com/"
* Verify element "kapat" is present and click
* Verify element "logo" is present

## Ürün Arama Senaryosu
tags: single
* Open "chrome" browser with notifications disabled
* Navigate to "https://www.trendyol.com/"
* Verify element "kapat" is present and click
* Verify element "mainsearchBox" is present
* Enter text "laptop" into "mainsearchBox"
* Click on element "searchButton"
* Verify element "firstProduct" is present
* Click on element "firstProduct"
* Wait for "2" seconds

//* Enter text "laptop" into "mainsearchBox" and click "searchButton"
//* Verify element "productDetail" is present
//* Verify element "addToCartButton" is present
//* Click on element "addToCartButton"
//* Verify element "cartConfirmation" is present

## Ürün Arama Senaryosu2
tags: single
* Open "chrome" browser with notifications disabled
* Navigate to "https://www.trendyol.com"
* Verify element "kapat" is present and click
* Hover over element "loginButton"
* Click on element "loginButton1"
* Enter text "testuser" into "usernameField"
* Enter text "password123" into "passwordField"
//* Verify element "homePageBanner" is present
//* Select dropdown option "Electronics" from "categoryDropdown"
//* Wait for "loadingIcon" to disappear
//* Scroll to element "footerSection"
//* Verify that element "promoBanner" is not present
//* Hover over element "accountMenu"
//* Check that element "cartIcon" is enabled
//* Click on element "searchIcon"
//* Enter text "phone" into "searchBox"
//* Verify that element "productList" is visible
//* Verify that text "Discount" is present in "promoLabel"
//
