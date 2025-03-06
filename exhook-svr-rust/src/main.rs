use pb::{
    ClientAuthenticateRequest, ClientAuthorizeRequest, ClientConnackRequest, ClientConnectRequest,
    ClientConnectedRequest, ClientDisconnectedRequest, ClientSubscribeRequest,
    ClientUnsubscribeRequest, EmptySuccess, HookSpec, LoadedResponse, MessageAckedRequest,
    MessageDeliveredRequest, MessageDroppedRequest, MessagePublishRequest, ProviderLoadedRequest,
    ProviderUnloadedRequest, SessionCreatedRequest, SessionDiscardedRequest, SessionResumedRequest,
    SessionSubscribedRequest, SessionTakenoverRequest, SessionTerminatedRequest,
    SessionUnsubscribedRequest, ValuedResponse,
};
use tonic::{transport::Server, Request, Response, Status};

type HookProviderResult<T> = Result<Response<T>, Status>;

pub mod pb {
    tonic::include_proto!("emqx.exhook.v3");
}

#[derive(Debug)]
pub struct HookProviderServer {}

#[tonic::async_trait]
impl pb::hook_provider_server::HookProvider for HookProviderServer {
    async fn on_provider_loaded(
        &self,
        req: Request<ProviderLoadedRequest>,
    ) -> HookProviderResult<LoadedResponse> {
        println!("{:#?}", req);
        let mut hooks = vec![];
        hooks.push(HookSpec {
            name: "client.connect".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "client.connected".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "client.authenticate".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "client.subscribe".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "client.connack".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "client.disconnected".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "client.authorize".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "client.unsubscribe".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "session.created".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "session.subscribed".into(),
            topics: Vec::new(),
        });

        hooks.push(HookSpec {
            name: "session.unsubscribed".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "session.resumed".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "session.discarded".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "session.takenover".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "session.terminated".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "message.publish".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "message.delivered".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "message.acked".into(),
            topics: Vec::new(),
        });
        hooks.push(HookSpec {
            name: "message.dropped".into(),
            topics: Vec::new(),
        });
        Ok(Response::new(LoadedResponse { hooks }))
    }

    async fn on_provider_unloaded(
        &self,
        req: Request<ProviderUnloadedRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_client_connect(
        &self,
        req: Request<ClientConnectRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_client_connack(
        &self,
        req: Request<ClientConnackRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_client_connected(
        &self,
        req: Request<ClientConnectedRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_client_disconnected(
        &self,
        req: Request<ClientDisconnectedRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_client_authenticate(
        &self,
        req: Request<ClientAuthenticateRequest>,
    ) -> HookProviderResult<ValuedResponse> {
        println!("{:#?}", req);
        Ok(Response::new(ValuedResponse {
            r#type: 0,
            value: Some(pb::valued_response::Value::BoolResult(true)),
        }))
    }

    async fn on_client_authorize(
        &self,
        req: Request<ClientAuthorizeRequest>,
    ) -> HookProviderResult<ValuedResponse> {
        println!("{:#?}", req);
        Ok(Response::new(ValuedResponse {
            r#type: 0,
            value: Some(pb::valued_response::Value::BoolResult(true)),
        }))
    }

    async fn on_client_subscribe(
        &self,
        req: Request<ClientSubscribeRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_client_unsubscribe(
        &self,
        req: Request<ClientUnsubscribeRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_session_created(
        &self,
        req: Request<SessionCreatedRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_session_subscribed(
        &self,
        req: Request<SessionSubscribedRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_session_unsubscribed(
        &self,
        req: Request<SessionUnsubscribedRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_session_resumed(
        &self,
        req: Request<SessionResumedRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_session_discarded(
        &self,
        req: Request<SessionDiscardedRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_session_takenover(
        &self,
        req: Request<SessionTakenoverRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_session_terminated(
        &self,
        req: Request<SessionTerminatedRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_message_publish(
        &self,
        req: Request<MessagePublishRequest>,
    ) -> HookProviderResult<ValuedResponse> {
        println!("{:#?}", req);
        Ok(Response::new(ValuedResponse {
            r#type: 0,
            value: Some(pb::valued_response::Value::BoolResult(true)),
        }))
    }

    async fn on_message_delivered(
        &self,
        req: Request<MessageDeliveredRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_message_dropped(
        &self,
        req: Request<MessageDroppedRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }

    async fn on_message_acked(
        &self,
        req: Request<MessageAckedRequest>,
    ) -> HookProviderResult<EmptySuccess> {
        println!("{:#?}", req);
        Ok(Response::new(EmptySuccess {}))
    }
}

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    let addr = "0.0.0.0:9000".parse()?;

    let server = HookProviderServer {};
    Server::builder()
        .add_service(pb::hook_provider_server::HookProviderServer::new(server))
        .serve(addr)
        .await
        .unwrap();
    Ok(())
}
