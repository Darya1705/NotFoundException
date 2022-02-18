package ru.netology.manager;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}


















    //private Product[] products = new Product[0];



   // public Product[] removeById(int id) {
     //   int length = products.length - 1;
       // Product[] tmp = new Product[length];
        //int index = 0;
        //for (Product product : products) {
          //      if (product.getId() != id) {
            //        tmp[index] = product;
              //      index++;
                //}
                //products = tmp;
            //}
        //try {
          //  return products;
        //} catch (StringIndexOutOfBoundsException nu) {

        //}
        //return null;
    //}
//}


// public NotFoundException(String message, Throwable cause) {
//   super(message, cause);
//}

//public NotFoundException(Throwable cause) {
//  super(cause);
//}

//public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//  super(message, cause, enableSuppression, writableStackTrace);
//}
