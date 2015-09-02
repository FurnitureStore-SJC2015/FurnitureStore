package com.exposit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ShoppingCart;
import com.exposit.domain.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCart shoppingCart;

	@Override
	public void addOneProduct(ProductCatalogUnit product) {
		shoppingCart.getItems().add(product);
		shoppingCart.setTotalPrice(shoppingCart.getTotalPrice()
				+ product.getCost());

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
			shoppingCart.setTotalPrice(shoppingCart.getTotalPrice()
					+ product.getCoefficient() * product.getCost());
		}

	}

	@Override
	public ShoppingCart getShoppingCart() {

		return this.shoppingCart;
	}

	@Override
	public void removeAt(int i) {
		shoppingCart.setTotalPrice(shoppingCart.getTotalPrice()
				- (shoppingCart.getItems().get(i).getCost())*(shoppingCart.getItems().get(i).getCoefficient()));
		shoppingCart.getItems().remove(i);

	}

	@Override
	public double getTotalPrice() {
		return shoppingCart.getTotalPrice();
	}

	@Override
	public void clearCart() {
		shoppingCart.getItems().clear();
		shoppingCart.setTotalPrice(0);

	}
}
