package helpers;

import java.util.ArrayList;

import online.store.core.Item;

public class ShoppingCart
{
	private ArrayList<Item> items;

	public ShoppingCart()
	{
		items = new ArrayList<Item>();
	};

	public void addItem(Item item)
	{
		items.add(item);
	};

	public void removeItem(Item item)
	{
		items.remove(item);
	};

	public Item[] getItems()
	{
		return (Item[]) items.toArray();
	};

	public void clear()
	{
		items.removeAll(items);
	};

}
