# Lalashop

This is an example of RESTful WebServer developed using Spring & SpringBoot.  
The app provides endpoints to manage the shop products data and data of its customers.  
The app is deployed to [Back4App](https://www.back4app.com)  
You can try one of the endpoints by clicking the link: [https://lalashop1-dgorodnichenko9.b4a.run/api/products](https://lalashop1-dgorodnichenko9.b4a.run/api/products).
> **Note**  
> Exposing data from db could take a while since the [hosting](https://freedb.tech) with the database has speed limitation in free tariff plan.

Also you can use [Swagger](https://lalashop1-dgorodnichenko9.b4a.run/api/swagger-ui/index.html#/) to see all endpoints in more convenient way.   


To see frontend page go to [frontend repository](https://github.com/dgorodnichenko/lalashop-frontend)

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
- [Swagger](https://lalashop1-dgorodnichenko9.b4a.run/api/swagger-ui/index.html#/)
- Lombok
- Maven

## REST APIs endpoints
> **Note**  
> Be aware that the API is using context path `/api` by defalt.  

### Retrieve a list of all products
```
GET api/products
```
***Curl***:
```
curl -X 'GET' 'http://lalashop1-dgorodnichenko9.b4a.run/api/products' -H 'accept: */*'
```

***Request URL***
```
http://lalashop1-dgorodnichenko9.b4a.run/api/products
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
curl -X 'GET' 'http://lalashop1-dgorodnichenko9.b4a.run/api/product/1' -H 'accept: */*'
```

***Request URL***
```
http://lalashop1-dgorodnichenko9.b4a.run/api/product/{id}
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
curl -X 'GET' 'http://lalashop1-dgorodnichenko9.b4a.run/api/search?keyword={keyword}' -H 'accept: */*'
```

***Request URL***
```
http://lalashop1-dgorodnichenko9.b4a.run/api/search?keyword={keyword}
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
curl -X 'GET' 'http://lalashop1-dgorodnichenko9.b4a.run/api/main_categories' -H 'accept: */*'
```

***Request URL***
```
http://lalashop1-dgorodnichenko9.b4a.run/api/main_categories
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
curl -X 'GET' 'http://lalashop1-dgorodnichenko9.b4a.run/api/subcategories' -H 'accept: */*'
```

***Request URL***
```
http://lalashop1-dgorodnichenko9.b4a.run/api/subcategories
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
curl -X 'GET' 'http://lalashop1-dgorodnichenko9.b4a.run/api/category/{id}' -H 'accept: */*'
```

***Request URL***
```
http://lalashop1-dgorodnichenko9.b4a.run/api/category/{id}
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
curl -X 'GET' 'http://lalashop1-dgorodnichenko9.b4a.run/api/countries' -H 'accept: */*'
```

***Request URL***
```
http://lalashop1-dgorodnichenko9.b4a.run/api/countries

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
curl -X 'GET' 'http://lalashop1-dgorodnichenko9.b4a.run/api/city/{country_code}' -H 'accept: */*'
```

***Request URL***
```
http://lalashop1-dgorodnichenko9.b4a.run/api/city/{country_code}
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
hhttp://lalashop1-dgorodnichenko9.b4a.run/api/user
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
curl -X 'POST' 'http://lalashop1-dgorodnichenko9.b4a.run/api/auth/signin' -H 'accept: */*' -H 'Content-Type: application/json' -d '{
  "email": {email},
  "password": "{password}"
}'
```
***Request URL***
```
http://lalashop1-dgorodnichenko9.b4a.run/api/auth/signin
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
curl -X 'POST' 'http://lalashop1-dgorodnichenko9.b4a.run/api/auth/signup' -H 'accept: */*' -H 'Content-Type: application/json' -d '{
  "email": {email},
  "firstName": {firstName},
  "lastName": {lastName},
  "password": {password},
  "confirmPassword": {confirmPassword}
}'
```
***Request URL***
```
http://lalashop1-dgorodnichenko9.b4a.run/api/auth/signup
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
http://lalashop1-dgorodnichenko9.b4a.run/api/purchase
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
