package com.OrderApp.Resources;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.OrderApp.DAOimp.ItemDaoImp;
import com.OrderApp.Models.Item;

@Path("/itemresources")
public class ItemResource {
	ItemDaoImp itemDaoImp = new ItemDaoImp();

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(@PathParam("id") int id) {
		Item itemId = itemDaoImp.searchItem(id);

		return Response.status(200).entity(itemId).build();
	}

	@POST
	@Path("save")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response saveItem(Item item) throws URISyntaxException {
		java.net.URI location = null;

		System.out.println(item.getItemName() + "  " + item.getItemDescription());
		
		itemDaoImp.addItem(item);

		location = new java.net.URI(
				"http://localhost:8080/RESTfullKnockout/pages/saveItem.jsp");
		return Response.seeOther(location).build();
	}

	@Path(value = "/getAllProducts")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String getAllItems() throws JSONException {

		List<Item> getAllItem = (List<Item>) itemDaoImp.getAllItems();

		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < getAllItem.size(); i++) {
			JSONObject item = new JSONObject();

			item.put("itemId", getAllItem.get(i).getItemId());
			item.put("itemName", getAllItem.get(i).getItemName());
			item.put("itemDescription", getAllItem.get(i).getItemDescription());
			item.put("itemPrice", getAllItem.get(i).getItemPrice());
			item.put("itemBrand", getAllItem.get(i).getItemBrand());

			jsonArray.put(item);
		}
		return jsonArray.toString();
	}
}
