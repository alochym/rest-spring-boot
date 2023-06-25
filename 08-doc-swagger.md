# Documents with Swagger

![Doc with Swagger](/images/doc-swagger.png).

## Swagger website

### Create Server YAML file

1. Add `Info`.
1. Add `Server`.
1. Add `Tags`.
1. Add `Path`.
1. Add `Operation`.
    1. Path `users`
    1. Operation `GET`.
    1. Summary.
    1. Description.
    1. Operation ID `findAll`.
1. Add `Example Response`.
    1. Path -> `/users`.
    1. Operation ID -> `GET`.
    1. Response:
        1. `Add button` -> `200`.
        1. `Media Type` -> `application/json`.
        1. Example Name: `A list of users`.
        1. Example Value: `the response list of users`.
1. Manual define an Object Model.

    ```yaml
    components:
        schema:
            user:
                type: object.
                properties:
                    id:
                        type: integer
                        format: int64
                        example: 99
                    name:
                        type: string
                        example: Do Nguyen Ha
                    email:
                        type: string
                        example: alochym@gmail.com
    ```

### Generate code with Swagger
