
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdateItemResponse_QNAME = new QName("http://server/", "updateItemResponse");
    private final static QName _DeleteItemResponse_QNAME = new QName("http://server/", "deleteItemResponse");
    private final static QName _GetAllItemsResponse_QNAME = new QName("http://server/", "getAllItemsResponse");
    private final static QName _UpdateItem_QNAME = new QName("http://server/", "updateItem");
    private final static QName _AddItemResponse_QNAME = new QName("http://server/", "addItemResponse");
    private final static QName _GetItem_QNAME = new QName("http://server/", "getItem");
    private final static QName _DeleteItem_QNAME = new QName("http://server/", "deleteItem");
    private final static QName _GetAllItems_QNAME = new QName("http://server/", "getAllItems");
    private final static QName _GetItemResponse_QNAME = new QName("http://server/", "getItemResponse");
    private final static QName _AddItem_QNAME = new QName("http://server/", "addItem");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddItem }
     * 
     */
    public AddItem createAddItem() {
        return new AddItem();
    }

    /**
     * Create an instance of {@link GetItemResponse }
     * 
     */
    public GetItemResponse createGetItemResponse() {
        return new GetItemResponse();
    }

    /**
     * Create an instance of {@link DeleteItem }
     * 
     */
    public DeleteItem createDeleteItem() {
        return new DeleteItem();
    }

    /**
     * Create an instance of {@link GetAllItems }
     * 
     */
    public GetAllItems createGetAllItems() {
        return new GetAllItems();
    }

    /**
     * Create an instance of {@link AddItemResponse }
     * 
     */
    public AddItemResponse createAddItemResponse() {
        return new AddItemResponse();
    }

    /**
     * Create an instance of {@link GetItem }
     * 
     */
    public GetItem createGetItem() {
        return new GetItem();
    }

    /**
     * Create an instance of {@link UpdateItem }
     * 
     */
    public UpdateItem createUpdateItem() {
        return new UpdateItem();
    }

    /**
     * Create an instance of {@link DeleteItemResponse }
     * 
     */
    public DeleteItemResponse createDeleteItemResponse() {
        return new DeleteItemResponse();
    }

    /**
     * Create an instance of {@link GetAllItemsResponse }
     * 
     */
    public GetAllItemsResponse createGetAllItemsResponse() {
        return new GetAllItemsResponse();
    }

    /**
     * Create an instance of {@link UpdateItemResponse }
     * 
     */
    public UpdateItemResponse createUpdateItemResponse() {
        return new UpdateItemResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "updateItemResponse")
    public JAXBElement<UpdateItemResponse> createUpdateItemResponse(UpdateItemResponse value) {
        return new JAXBElement<UpdateItemResponse>(_UpdateItemResponse_QNAME, UpdateItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "deleteItemResponse")
    public JAXBElement<DeleteItemResponse> createDeleteItemResponse(DeleteItemResponse value) {
        return new JAXBElement<DeleteItemResponse>(_DeleteItemResponse_QNAME, DeleteItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getAllItemsResponse")
    public JAXBElement<GetAllItemsResponse> createGetAllItemsResponse(GetAllItemsResponse value) {
        return new JAXBElement<GetAllItemsResponse>(_GetAllItemsResponse_QNAME, GetAllItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "updateItem")
    public JAXBElement<UpdateItem> createUpdateItem(UpdateItem value) {
        return new JAXBElement<UpdateItem>(_UpdateItem_QNAME, UpdateItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "addItemResponse")
    public JAXBElement<AddItemResponse> createAddItemResponse(AddItemResponse value) {
        return new JAXBElement<AddItemResponse>(_AddItemResponse_QNAME, AddItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getItem")
    public JAXBElement<GetItem> createGetItem(GetItem value) {
        return new JAXBElement<GetItem>(_GetItem_QNAME, GetItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "deleteItem")
    public JAXBElement<DeleteItem> createDeleteItem(DeleteItem value) {
        return new JAXBElement<DeleteItem>(_DeleteItem_QNAME, DeleteItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getAllItems")
    public JAXBElement<GetAllItems> createGetAllItems(GetAllItems value) {
        return new JAXBElement<GetAllItems>(_GetAllItems_QNAME, GetAllItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "getItemResponse")
    public JAXBElement<GetItemResponse> createGetItemResponse(GetItemResponse value) {
        return new JAXBElement<GetItemResponse>(_GetItemResponse_QNAME, GetItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server/", name = "addItem")
    public JAXBElement<AddItem> createAddItem(AddItem value) {
        return new JAXBElement<AddItem>(_AddItem_QNAME, AddItem.class, null, value);
    }

}
