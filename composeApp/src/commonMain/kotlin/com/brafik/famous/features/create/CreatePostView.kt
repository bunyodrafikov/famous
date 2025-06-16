package com.brafik.famous.features.create

@Composable
fun CreatePostView(
    viewState: CreatePostViewState,
    eventHandler: (CreatePostEvent) -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth().height(72.dp)) {
        Text("Title", color = FamousTheme.colors.primaryText,
            fontSize = 16.sp)
    }
}

@Composable
@Preview
fun CreatePostView_Preview() {
    AppTheme {
        CreatePostView(
            viewState = CreatePostViewState()
        ) {

        }
    }
}