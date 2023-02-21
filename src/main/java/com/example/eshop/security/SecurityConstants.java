package com.example.eshop.security;

public class SecurityConstants {
    public static final String HEADER_STRING = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SECRET_KEY = "71337436763979244226452948404D635166546A576E5A7234753778217A2543";

    //Allowed URLs
    public static final String SIGN_UP_URL = "/auth/**";
    public static final String ALL_PRODUCTS_URL = "/products";
    public static final String PRODUCTS_BY_CATEGORY_URL = "/category/**";
    public static final String SPECIFIC_PRODUCT_URL = "/product/**";
    public static final String SEARCH_URL = "/search/**";
    public static final String MAIN_CATEGORIES_URL = "/main_categories/**";
    public static final String SUBCATEGORIES_URL = "/subcategories";
    public static final String COUNTRIES_URL = "/countries";
    public static final String CITIES_URL = "/city/**";
    public static final String CHECKOUT_URL = "/purchase";
    public static final String SWAGGER_URL = "/swagger-ui/**";
    public static final String SWAGGER_DOCS_URL = "/v3/api-docs/**";
}