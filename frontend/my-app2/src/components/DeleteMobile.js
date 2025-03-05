import { useState, useEffect } from "react";
import { useParams, useNavigate, Link } from "react-router-dom";
import axios from 'axios';

function DeleteMobile() {

    const [mobile, setMobile] = useState(null);
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        axios.get("http://localhost:8081/mobile/" + id)
            .then(resp => setMobile(resp.data));
    }, [id])

    const handleDelete = () => {

        if (window.confirm("Are you Deleting this mobile?")) {
            axios.delete("http://localhost:8081/mobile/" + id)
                .then(resp => {
                    alert("Mobile Deleted");
                    navigate(-1);
                })
        }
    }

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
                    <p>
                        <button onClick={handleDelete}>Delete</button>
                        <Link to="/mobile/all"><button>Cancel</button></Link>
                    </p>
                </div>
            }

        </>
    )
}

export default DeleteMobile;