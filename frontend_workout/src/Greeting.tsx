// After: MyComponent.tsx
import React, { FC } from 'react';

// Define a type for the component props
interface MyComponentProps {
    greeting: string;
}

// Use the 'FC' (Functional Component) generic from React, with our props type
const XD: FC<MyComponentProps> = ({ greeting }) => {
    return <h1>{greeting}, world!</h1>;
}

export default XD;