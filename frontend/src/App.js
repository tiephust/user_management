import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
    const [message, setMessage] = useState("");
    const [users, setUsers] = useState([]);

    useEffect(() => {
        // Gọi API /home
        axios.get("http://localhost:8080/home")
            .then(res => setMessage(res.data))
            .catch(err => console.error(err));

        // Gọi API /all-users
        axios.get("http://localhost:8080/all-users")
            .then(res => setUsers(res.data))
            .catch(err => console.error(err));
    }, []);

    return (
        <div>
            <h1>{message}</h1>

            <h2>Danh sách người dùng:</h2>
            <ul>
                {users.map(user => (
                    <li key={user.id}>
                        {user.username} - {user.email} - {user.role}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
