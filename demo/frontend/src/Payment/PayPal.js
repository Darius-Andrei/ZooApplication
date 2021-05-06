import React, {useRef, useEffect} from 'react'

export default function PayPal() {
    const paypal=useRef()

    useEffect(()=>{
        window.paypal.Buttons({
            createOrder : (data,actions, err) =>{
                return actions.order.create({
                    intent: "CAPTURE",
                    purchase_units:[{
                        description:"Yes I do want to buy it",
                        amount: {
                            currency_code: "USD",
                            value: 650.00
                        }
                    }]
                })
            },
            onApprove: async (data, actions) =>{
                const order = await actions.order.capture()
                console.log("Succesful order" + order)
            },
            onError: (err) =>{
                console.log(err)
            }
        })
        .render(paypal.current);
    }, []);
    return (
        <div>
            <div ref={paypal}></div>
        </div>
    )
}