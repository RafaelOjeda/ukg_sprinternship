import { Navigate } from 'react-router-dom';
import { useUser } from './UserContext';

const PrivateRoutes = ({ children }) => {

        const { loginToken } = useUser();


    if (!loginToken) {
        return <Navigate to="/signin"/>;
    } else {
        return children;
        }

console.log(useUser().loginToken);
}

export default PrivateRoutes;