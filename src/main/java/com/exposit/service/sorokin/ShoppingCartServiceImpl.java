package com.exposit.service.sorokin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exposit.domain.model.sorokin.ShoppingCart;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.sorokin.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCart shoppingCart;

	@Override
	public void addOneProduct(ProductCatalogUnit product) {
		shoppingCart.getItems().add(product);

	}

	@Override
	public void deleteOneProduct(ProductCatalogUnit product) {
		shoppingCart.getItems().remove(product);

	}

	@Override
	public List<ProductCatalogUnit> getAllProductsInShoppingCart() {
		return shoppingCart.getItems();
	}

	@Override
	public void addProduct(Integer count, ProductCatalogUnit product) {
		for (int i = 0; i < count; i++) {
			shoppingCart.getItems().add(product);
		}

	}

	@Override
	public ShoppingCart getShoppingCart() {

		return this.shoppingCart;
	}

}
