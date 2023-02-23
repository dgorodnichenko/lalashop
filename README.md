# Lalashop

This is an example of RESTful WebServer developed using Spring & SpringBoot.
The server provides endpoints to manage products data of the shop and data of its customers.
The server is deployed to Heroku and provides data for an simple example of an internet shop. To try a full web go to [https://lalashopper.herokuapp.com/products](https://lalashopper.herokuapp.com/products).

## Content
- [Technologies](#technologies)
- [REST APIs endpoints](#rest-apis-endpoints)
   - [Retrieve a list of all products](#retrieve-a-list-of-all-products)
   - [Get a product by id](#get-a-product-by-id)
   - [Find products by a keyword](#find-products-by-a-keyword)
   - [Get main categories of products](#get-main-categories-of-products)
   - [Get subcategories of main categories](#get-subcategories-of-main-categories)
   - [Get products by category](#get-products-by-category)
   - [Get available countries for delivering](#get-available-countries-for-delivering)
   - [Get cities by country code](#get-cities-by-country-code)
   - [Get principal of current user](#get-principal-of-current-user)
   - [Login](#login)
   - [Registration](#registration)
   - [Buy a product](#buy-a-product)
    

## Technologies
- JDK 19
- Spring Framework (Spring Boot 3.0.2, Spring Data, Spring Security 3.0.2)
- MySQL
- [Swagger](https://lalashopping.herokuapp.com/api/swagger-ui/index.html)
- Lombok
- Maven

## REST APIs endpoints
Be aware that the API is using context path `/api` by defalt.

### Retrieve a list of all products
```
GET api/products
```
***Curl***:
```
curl -X 'GET' 'https://lalashopping.herokuapp.com/api/products' -H 'accept: */*'
```

***Request URL***
```
https://lalashopping.herokuapp.com/api/products
```

***Response Header***
```
content-type: application/json 
vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
```

***Response Body***
```
[
  {
    "id": {id},
    "name": {name}
    "description": {description},
    "price": {price},
    "imageUrl": {imageUrl},
    "unitsInStock": {unitsInStock},
    "dateCreated": {dateCreated},
    "dateUpdated": {dateUpdated},
    "productCategory": {
      "id": {subcategory_id},
      "name": {subcategory_name},
      "mainProductCategory": {
        "id": {mainCategoryId},
        "name": {mainCategoryName} 
      }
    }
  }, { ... }
]
```

### Get a product by id
```GET api/product/{id}```

***Curl*** 
```
curl -X 'GET' 'https://lalashopping.herokuapp.com/api/product/1' -H 'accept: */*'
```

***Request URL***
```
https://lalashopping.herokuapp.com/api/product/{id}
```

***Response Header***
```
content-type: application/json 
vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
```

***Response Body***
```
{
  "id": {id},
  "name": {name}
  "description": {description},
  "price": {price},
  "imageUrl": {imageUrl},
  "unitsInStock": {unitsInStock},
  "dateCreated": {dateCreated},
  "dateUpdated": {dateUpdated},
  "productCategory": {
    "id": {subcategory_id},
    "name": {subcategory_name},
    "mainProductCategory": {
      "id": {mainCategoryId},
      "name": {mainCategoryName} 
    }
  }
}
```

If no product found you wil get error with status 403

### Find products by a keyword
```
GET api/search
```
***Curl***
```
curl -X 'GET' 'https://lalashopping.herokuapp.com/api/search?keyword={keyword}' -H 'accept: */*'
```

***Request URL***
```
https://lalashopping.herokuapp.com/api/search?keyword={keyword}
```

***Response Header***
```
content-type: application/json 
vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
```
***Response Body***
```
[
  {
    "id": {id},
    "name": {name}
    "description": {description},
    "price": {price},
    "imageUrl": {imageUrl},
    "unitsInStock": {unitsInStock},
    "dateCreated": {dateCreated},
    "dateUpdated": {dateUpdated},
    "productCategory": {
      "id": {subcategory_id},
      "name": {subcategory_name},
      "mainProductCategory": {
        "id": {mainCategoryId},
        "name": {mainCategoryName} 
      }
    }
  }, { ... }
]
```

### Get main categories of products
```
GET api/main_categories
```
***Curl***
```
curl -X 'GET' 'https://lalashopping.herokuapp.com/api/main_categories' -H 'accept: */*'
```

***Request URL***
```
https://lalashopping.herokuapp.com/api/main_categories
```

***Response Header***
```
content-type: application/json 
vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
```
***Response Body***
```
[
  {
    "id": {id},
    "name": {name}
  }, { ... }
]
```

### Get subcategories of main categories
```
GET api/subcategories
```
***Curl***
```
curl -X 'GET' 'https://lalashopping.herokuapp.com/api/subcategories' -H 'accept: */*'
```

***Request URL***
```
https://lalashopping.herokuapp.com/api/subcategories
```

***Response Header***
```
content-type: application/json 
vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
```
***Response Body***
```
[
  {
    "id": {id},
    "name": {name},
    "mainProductCategory": {
      "id": {mainCategoryId},
      "name": {mainCategoryName}
    }
  }, { ... }
]
```

### Get products by category
```
GET api/category/{id}
```
***Curl***
```
curl -X 'GET' 'https://lalashopping.herokuapp.com/api/category/1' -H 'accept: */*'
```

***Request URL***
```
https://lalashopping.herokuapp.com/api/category/1
```

***Response Header***
```
content-type: application/json 
vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
```
***Response Body***
```
[
  {
    "id": {id},
    "name": {name}
    "description": {description},
    "price": {price},
    "imageUrl": {imageUrl},
    "unitsInStock": {unitsInStock},
    "dateCreated": {dateCreated},
    "dateUpdated": {dateUpdated},
    "productCategory": {
      "id": {subcategory_id},
      "name": {subcategory_name},
      "mainProductCategory": {
        "id": {mainCategoryId},
        "name": {mainCategoryName} 
      }
    }
  }, { ... }
]
```

### Get available countries for delivering
```
GET api/countries
```
***Curl***
```
curl -X 'GET' 'https://lalashopping.herokuapp.com/api/countries' -H 'accept: */*'
```

***Request URL***
```
https://lalashopping.herokuapp.com/api/countries

```

***Response Header***
```
content-type: application/json 
vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
```
***Response Body***
```
[
  {
    "id": {id},
    "code": {code},
    "name": {name}
  }
]
```

### Get cities by country code
For now only UA country code is available
```
GET api/cities/{country_code}
```
***Curl***
```
curl -X 'GET' 'https://lalashopping.herokuapp.com/api/city/{country_code}' -H 'accept: */*'
```

***Request URL***
```
https://lalashopping.herokuapp.com/api/city/{country_code}
```

***Response Header***
```
content-type: application/json 
vary: Origin,Access-Control-Request-Method,Access-Control-Request-Headers 
```
***Response Body***
```
[
  {
    "id": {id},
    "name": {name},
    "country": {
      "id": {country_id},
      "code": {country_code},
      "name": {country_name}
    }
  }, { ... }
]
```

### Get principal of current user
```
GET api/user
```

***Request URL***
```
https://lalashopping.herokuapp.com/api/user
```

***Required Request Header***
```
Authorization: Bearer {jwt_token}
```

***Response Body***
```
{
  "id": {id},
  "firstName": {firstName},
  "lastName": {lastName},
  "email": {email},
  "password": {password},
  "dateCreated": {dateCreated},
  "role": {role},
  "enabled": true,
  "accountNonExpired": true,
  "accountNonLocked": true,
  "credentialsNonExpired": true,
  "username": {username},
  "authorities": [
    {
      "authority": {authority}
    }
  ]
}
```

### Login
```
POST api/auth/signin
```

***Curl***
```
curl -X 'POST' 'https://lalashopping.herokuapp.com/api/auth/signin' -H 'accept: */*' -H 'Content-Type: application/json' -d '{
  "email": {email},
  "password": "{password}"
}'
```
***Request URL***
```
https://lalashopping.herokuapp.com/api/auth/signin
```
***Request body***
```
{
  "email": {email},
  "password": {password}
}
```

***Response Body***
```
{
  "token": {token}
}
```

### Registration
```
POST api/auth/signup
```

***Curl***
```
curl -X 'POST' 'https://lalashopping.herokuapp.com/api/auth/signup' -H 'accept: */*' -H 'Content-Type: application/json' -d '{
  "email": {email},
  "firstName": {firstName},
  "lastName": {lastName},
  "password": {password},
  "confirmPassword": {confirmPassword}
}'
```
***Request URL***
```
https://lalashopping.herokuapp.com/api/auth/signup
```

***Request body***
```
{
  "email": {email},
  "firstName": {firstName},
  "lastName": {lastName},
  "password": {password},
  "confirmPassword": {confirmPassword}
}
```

***Response Body***
```
{
  "token": {token}
}
```

### Buy a product
```
POST api/purchase
```

***Request URL***
```
https://lalashopping.herokuapp.com/api/purchase
```
***Required body***
```
{
  "customer": {
    "id": {id},
    "firstName": {firstName},
    "lastName": {lastName},
    "email": {email},
    "country": {country},
    "city": {city},
    "address": {address},
    "zipCode": {zipCode}
  },
  "order": {
    "id": {order_id},
    "orderTrackingNumber": {orderTrackingNumber},
    "totalPrice": {totalPrice},
    "totalQuantity": {totalQuantity},
    "status": {status},
    "dateCreated": {dateCreated},
    "lastUpdated": {lastUpdated},
    "customer": {
      "id": {customer_id},
      "firstName": {firstName},
      "lastName": {lastName},
      "email": {email},
      "country": {country},
      "city": {city},
      "address": {address},
      "zipCode": {zipCode}
    }
  },
  "orderItems": [
    {
      "id": {item_id},
      "quantity": {quantity},
      "price": {price},
      "productId": {productId},
      "order": {
        "id": {order_id},
        "orderTrackingNumber": {orderTrackingNumber},
        "totalPrice": {totalPrice},
        "totalQuantity": {totalQuantity},
        "status": {status},
        "dateCreated": {dateCreated},
        "lastUpdated": {lastUpdated},
        "customer": {
          "id": {customer_id},
          "firstName": {firstName},
          "lastName": {lastName},
          "email": {email},
          "country": {country},
          "city": {city},
          "address": {address},
          "zipCode": {zipCode}
        }
      }
    }
  ]
}
```
***Response Body***
```
{
  "orderTrackingNumber": {orderTrackingNumber}
}
```
