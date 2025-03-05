import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';

function EditMobile() {

    const [mobileId, setMobileId] = useState('');
    const [mname, setMname] = useState('');
    const [mprice, setMprice] = useState('');
    const [mfd, setMfd] = useState('');
    const [mcompany, setMcompany] = useState('');

    const { id } = useParams();

    const navigate = useNavigate();

    useEffect(() => {
        axios.get("http://localhost:8081/mobile/" + id)
            .then(resp => {
                setMobileId(resp.data.mobileId);
                setMname(resp.data.mobileName);
                setMprice(resp.data.price);
                setMfd(resp.data.mfd);
                setMcompany(resp.data.companyName);
            });
    }, [id])

    const handleUpdate = () => {

        const payload = {
            mobileId: mobileId,
            mobileName: mname,
            price: mprice,
            mfd: mfd,
            companyName: mcompany
        }

        axios.put("http://localhost:8081/mobile/", payload)
            .then(resp => {

                alert("Mobile Updated!!");

                // navigate("/mobile/all"); //navigate to fetch all page
                navigate(-1); // navigat to previous page
            })
    }

    return (
        <>
            <h3>Mobile Form</h3>
            <div>
                <label>Id</label>
                <input type="text" name="mobileId" value={mobileId}
                    onChange={(event) => setMobileId(event.target.value)} disabled />
            </div>
            <div>
                <label>Name</label>
                <input type="text" name="mname" value={mname}
                    onChange={(event) => setMname(event.target.value)} />
            </div>
            <div>
                <label>Price</label>
                <input type="text" name="mprice" value={mprice}
                    onChange={(event) => setMprice(event.target.value)} />
            </div>
            <div>
                <label>MFD</label>
                <input type="date" name="mfd" value={mfd}
                    onChange={(event) => setMfd(event.target.value)} />
            </div>
            <div>
                <label>Company Name</label>
                <input type="text" name="mcompany" value={mcompany}
                    onChange={(event) => setMcompany(event.target.value)} />
            </div>

            <input type="submit" onClick={handleUpdate} />

        </>
    )
}

export default EditMobile;