import { useEffect, useState } from "react";
import axios from 'axios';
import { useParams } from "react-router-dom";

function FetchMobileDetails() {

    const [mobile, setMobile] = useState(null);

    const {mid} = useParams();

    useEffect(() => {
        axios.get("http://localhost:8081/mobile/"+mid)
            .then(resp => setMobile(resp.data));
    }, [mid])

    return (
        <>
            <h3>Mobile Details</h3>
            {
                mobile !== null &&
                <div>
                    <p>Id: {mobile.mobileId}</p>
                    <p>Name: {mobile.mobileName}</p>
                    <p>Price: {mobile.price}</p>
                    <p>MFD: {mobile.mfd}</p>
                    <p>Company: {mobile.companyName}</p>
                </div>
            }
        </>
    )
}

export default FetchMobileDetails;