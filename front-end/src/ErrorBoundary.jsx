import React from "react";
import axios from 'axios';

function logError(error, info) {
  const log = {
    message: error.message,
    stack: error.stack,
    info: info,
    timestamp: new Date().toISOString(),
  };

  console.log("Sending log:", log);
  sendLogToServer(log);
}

function sendLogToServer(log) {
  axios.post("http://localhost:8091/log", log, {
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => console.log("Server response:", response.data))
    .catch((err) => console.error("Failed to send log:", err));
}

class ErrorBoundary extends React.Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false };
  }

  static getDerivedStateFromError(error) {
    return { hasError: true };
  }

  componentDidCatch(error, info) {
    logError(error, info);
  }

  render() {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }
    return this.props.children;
  }
}

export default ErrorBoundary;