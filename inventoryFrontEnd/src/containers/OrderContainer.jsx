import OrderList from "../components/OrderList"
import OrderForm from "../components/OrderForm"
import OrderDetail from "../components/OrderDetail"
import '../styling/OrderContainer.css'
import { useState } from "react"
import {Routes, Route} from "react-router-dom"




const OrderContainer = ({orders, refresh}) => {

    const handlePost = (order) =>{
        console.log("handlePost triggered");
        fetch("/api/orders", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(order)
        })
        .then(() => refresh())
    }

return(
    <div className="orderContainer">
        <Routes>
            <Route path ="/" element ={<OrderList orders ={orders}/>}/>

            <Route path ="/new" element = {<OrderForm  handlePost ={handlePost}/>}/>

            <Route path ="/:id" element = {<OrderDetail/>}/>
        </Routes>
    </div>
)   
}


export default OrderContainer