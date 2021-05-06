import React, {useState} from 'react';
import PayPal from './PayPal';

const PayPalFake= () =>{
    const [checkout, setCheckOut] = useState(false)
    return(
        <div>
            {checkout ? (
                <PayPal />
            ) : (
            <button onClick={()=> {setCheckOut(true);
            }}
            >
                Checkout
            </button>
            )}
        </div>
    );    
}
export default PayPalFake